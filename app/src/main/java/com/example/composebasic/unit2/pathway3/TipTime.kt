package com.example.composebasic.unit2.pathway3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composebasic.R
import com.example.composebasic.ui.theme.TipTimeTheme
import java.text.NumberFormat

/**A-unit2-pathway3 path3 Intro to state in Compose**/
//(section1-2 video)
//A_1-2 Begin & App Description
//A_3 add TextField
//A_4 add Use state in Compose
//A_5 The Composition (State, MutableState), Bunlar değiştikçe arayüzü de güncellememize olanak sağlar.
//A_6 Use remember function to save state (Bkz. A_6.1)
//A_7 remember'ın sürekli çalıştığını göstermek içim Debug koşuluyor.
//A_8 Modify the appearance(A_8.1 -> Add a label to the text box. A_8.2 -> keyboardOptions)
//A_9 Display the tip amount (Bkz. A_9.1, A_9.2)
//A_10 State hoisting -> EditNumberField içindeki tip değişkenini nasıl fonksiyonun dışına alabiliriz?
//(A_10.1, A_10.2, A_10.3)

/**B-unit2-pathway3 path4 Calculate a custom tip**/
//B_1-2 introduction)
//B_3 strings.xml değişiklikleri
//B_4 Add a tip-percentage text field (EditNumberField'a yeniden kullanmak için label eklenmesi)
//B_5 Set an action button(ImeAction.Search, ImeAction.Send, ImeAction.Go)
//B_6 Add a switch
//B_7 Add support for landscape orientation
//B_8 Add leading icon to text fields (optional)

class TipTime : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TipTimeTheme() {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TipTimeLayoutX()
                }
            }
        }
    }
}

//B_6
@Composable
fun RoundTheTipRowX(
    roundUp: Boolean,//switch değiştiğinde çalışan callback
    onRoundUpChanged: (Boolean) -> Unit, //switch değiştiğinde çalışan callback
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .size(48.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = stringResource(R.string.round_up_tip))
        Switch(
            modifier = modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.End),
            checked = roundUp,
            onCheckedChange = onRoundUpChanged,
        )
    }
}

@Composable
fun TipTimeLayoutX() {
    var roundUp by remember { mutableStateOf(false) }
    var amountInput by remember { mutableStateOf("") }
    var tipInput by remember { mutableStateOf("") }
    val tipPercent = tipInput.toDoubleOrNull() ?: 0.0
    val amount = amountInput.toDoubleOrNull() ?: 0.0 //amountInput = it kodu ile güncelleniyor.
    val tip = calculateTip(amount, tipPercent, roundUp)
    Column(
        modifier = Modifier
            .padding(40.dp)
            .verticalScroll(rememberScrollState()), //B_7
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.calculate_tip),
            modifier = Modifier
                .padding(bottom = 16.dp)
                .align(alignment = Alignment.Start)
        )
        EditNumberFieldX(
            label = R.string.bill_amount,
            leadingIcon = R.drawable.money,//B_8
            value = amountInput,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,// A_8.2 sadece numara girilebilsin diye klavye ayarı yapıldı.
                imeAction = ImeAction.Next//B_5
            ),
            onValueChange = {
                amountInput = it
            }, //A_10.2 EditNumberField içinde değişecek olan tip değerini almak için
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth()
        ) //A_3'ün genel çizimde yer alması
        EditNumberFieldX(
            label = R.string.how_was_the_service,
            leadingIcon = R.drawable.percent,//B_8
            value = tipInput,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number, //A_8.2 sadece numara girilebilsin diye klavye ayarı yapıldı.
                imeAction = ImeAction.Done //B_5
            ),
            onValueChange = { tipInput = it },
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth()
        )
        RoundTheTipRowX(
            roundUp = roundUp,
            onRoundUpChanged = { roundUp = it },
            modifier = Modifier.padding(bottom = 32.dp)
        )
        Text(
            text = stringResource(
                R.string.tip_amount,
                tip
            ), //A_10.3 formatlama ve EditNumberField içinden alınan tip değerinin
            style = MaterialTheme.typography.displaySmall
        ) //A_9.2
        Spacer(modifier = Modifier.height(150.dp))
    }
}

//A_9
private fun calculateTip(
    amount: Double, tipPercent: Double = 15.0,
    roundUp: Boolean//B_6
): String {
    var tip = tipPercent / 100 * amount
    if (roundUp)
        tip = kotlin.math.ceil(tip) //
    return NumberFormat.getCurrencyInstance().format(tip)
}

//A_3 Tutarın girileceği TextField'ın çizilmesi
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditNumberFieldX(
    @StringRes label: Int, //resource reference ile geleceğinden @StringRes anotasyonu eklendi
    @DrawableRes leadingIcon: Int,//B_8
    value: String,
    keyboardOptions: KeyboardOptions,
    onValueChange: (String) -> Unit,//A_10.1 String alır dönüş değeri yoktur.
    modifier: Modifier = Modifier,
) {
    //A_4 val amountInput = "0" (sabit değer kullanıcıdan alınmadı)
    TextField(
        value = value,
        onValueChange = onValueChange,//A_6.1Değişen değeri remember state olan değişkene atayarak dinamik girdi alabiliyoruz.
        leadingIcon = { Icon(painter = painterResource(id = leadingIcon), null) },
        modifier = modifier,
        label = { Text(stringResource(label)) },//A_8.1
        singleLine = true,//A_8 Girdinin Tek satır olması için
        keyboardOptions = keyboardOptions
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview2() {
    TipTimeTheme {
        TipTimeLayoutX()
    }
}