package com.example.composebasic.unitx.kokulata

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
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
import com.example.composebasic.unit2.pathway3.calculateTipX
import com.example.composebasic.unit3.pathway3.path2.ui.theme.ProductPriceTheme
import java.text.NumberFormat

class ProductPrice : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProductPriceTheme() {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ProductPriceLayout()
                }
            }
        }
    }
}

@Composable
fun ProductPriceLayout() {

    var fullAmountInput by remember { mutableStateOf("") }

    var vatRatio by remember { mutableStateOf("") }
    val vatPercent = vatRatio.toDoubleOrNull() ?: 0.00

    var commissionRatio by remember { mutableStateOf("") }
    val commissionPercent = commissionRatio.toDoubleOrNull() ?: 0.00

    var shippingAmount by remember { mutableStateOf("") }
    val shippingAmountDouble = shippingAmount.toDoubleOrNull() ?: 0.00

    var desiredProfitRatio by remember { mutableStateOf("") }
    val desiredProfitRatioPercent = desiredProfitRatio.toDoubleOrNull() ?: 0.00

    val fullAmount = fullAmountInput.toDoubleOrNull() ?: 0.00
    val vatAmount = calculateOnlyVATAmount(fullAmount, vatPercent)
    val commissionAmount = calculateOnlycommissionAmount(fullAmount, commissionPercent)
    val moneyInPocketAmount =
        calculateMoneyInPocket(fullAmount, commissionAmount, shippingAmountDouble, vatAmount)

    val desiredAmount = calculateDesiredAmount(moneyInPocketAmount,desiredProfitRatioPercent)
    Column(
        modifier = Modifier
            .padding(40.dp)
            .verticalScroll(rememberScrollState()), //B_7
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.fitness_amount),
            modifier = Modifier
                .padding(bottom = 16.dp)
                .align(alignment = Alignment.Start)
        )
        EditNumberFieldProductPrice(
            label = R.string.sale_price,
            leadingIcon = R.drawable.money,
            value = fullAmountInput,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            onValueChange = {
                fullAmountInput = it
            },
            modifier = Modifier
                .padding(bottom = 10.dp)
                .fillMaxWidth()
        )
        EditNumberFieldProductPrice(
            label = R.string.vat_ratio,
            leadingIcon = R.drawable.percent,
            value = vatRatio,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            onValueChange = { vatRatio = it },
            modifier = Modifier
                .padding(bottom = 10.dp)
                .fillMaxWidth()
        )

        EditNumberFieldProductPrice(
            label = R.string.commission_ratio,
            leadingIcon = R.drawable.percent,
            value = commissionRatio,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            onValueChange = { commissionRatio = it },
            modifier = Modifier
                .padding(bottom = 10.dp)
                .fillMaxWidth()
        )

        EditNumberFieldProductPrice(
            label = R.string.shipping_amount,
            leadingIcon = R.drawable.cargo,
            value = shippingAmount,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            onValueChange = { shippingAmount = it },
            modifier = Modifier
                .padding(bottom = 10.dp)
                .fillMaxWidth()
        )

        EditNumberFieldProductPrice(
            label = R.string.desired_profit_rate,
            leadingIcon = R.drawable.profit_ratio,//B_8
            value = desiredProfitRatio,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number, //A_8.2 sadece numara girilebilsin diye klavye ayarı yapıldı.
                imeAction = ImeAction.Done //B_5
            ),
            onValueChange = { desiredProfitRatio = it },
            modifier = Modifier
                .padding(bottom = 10.dp)
                .fillMaxWidth()
        )

        Text(
            text = stringResource(
                R.string.estimated_purchase_value,
                desiredAmount
            ), //A_10.3 formatlama ve EditNumberField içinden alınan tip değerinin
            style = MaterialTheme.typography.displayMedium
        )
        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = stringResource(
                R.string.only_vat_price,
                vatAmount
            ),
            Modifier.align(Alignment.Start)
        )
        Text(
            text = stringResource(
                R.string.only_commission_price,
                commissionAmount
            ),
            Modifier.align(Alignment.Start)
        )
        Text(
            text = stringResource(
                R.string.money_in_pocket_amount,
                moneyInPocketAmount
            ),
            Modifier.align(Alignment.Start)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditNumberFieldProductPrice(
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


@Preview(showBackground = true)
@Composable
fun ProductPricePreview() {
    ProductPriceTheme {
        ProductPriceLayout()
    }
}


fun calculateOnlyVATAmount(
    fullAmount: Double, vatRatio: Double,
): Double {
    var vatPrice = (100 * fullAmount) / (100 + vatRatio)
    return fullAmount - vatPrice
}

fun calculateOnlycommissionAmount(
    fullAmount: Double, commissionRatio: Double,
): Double {
    var commissionPrice = fullAmount * commissionRatio / 100
    return commissionPrice
}


fun calculateDesiredAmount(
    moneyInPocket: Double, desiredRatio: Double,
): String {
    var desiredAmount = (100 * moneyInPocket) / (desiredRatio + 100)
    return NumberFormat.getCurrencyInstance().format(desiredAmount)
}

fun calculateMoneyInPocket(
    fullAmount: Double, commissionAmount: Double, shippingAmount: Double, vatAmount: Double,
): Double {
    var desiredAmount = fullAmount - commissionAmount - shippingAmount - vatAmount
    return desiredAmount
}