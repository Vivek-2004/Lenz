package com.fitting.lenz

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fitting.lenz.models.AdminLoginBody
import com.fitting.lenz.models.FittingChagresResponse
import com.fitting.lenz.models.FittingChargesData
import com.fitting.lenz.models.FittingDataFullFrame
import com.fitting.lenz.models.FittingDataRimless
import com.fitting.lenz.models.FittingDataSupra
import com.fitting.lenz.models.LowHigh
import com.fitting.lenz.models.ShiftingChargesUpdated
import com.fitting.lenz.models.ShopDetails
import com.fitting.lenz.models.SingleDouble
import com.fitting.lenz.models.UpdatedFittingChargesData
import kotlinx.coroutines.launch
import retrofit2.HttpException

class LenzViewModel : ViewModel() {
    private val _lenzService = lenzService

    var adminConfirmation by mutableStateOf(false)
        private set
    var shopsList by mutableStateOf<List<ShopDetails>>(emptyList())
        private set

    var shiftingFullFrameCharges by mutableStateOf("0")
    var shiftingSupraCharges by mutableStateOf("0")
    var shiftingRimLessCharges by mutableStateOf("0")
    var shiftingUpdateConfirmation by mutableStateOf(false)
    var fittingUpdateConfirmation by mutableStateOf(false)
    var testResponse by mutableStateOf("VIVEK TEST")

//  -----------------------------------------------------------------
    var fittingFullFrameNormal_LS by mutableStateOf("0")
    var fittingFullFrameNormal_LD by mutableStateOf("0")
    var fittingFullFrameNormal_HS by mutableStateOf("0")
    var fittingFullFrameNormal_HD by mutableStateOf("0")
    var fittingFullFramePR_LS by mutableStateOf("0")
    var fittingFullFramePR_LD by mutableStateOf("0")
    var fittingFullFramePR_HS by mutableStateOf("0")
    var fittingFullFramePR_HD by mutableStateOf("0")
    var fittingFullFrameSunglass_LS by mutableStateOf("0")
    var fittingFullFrameSunglass_LD by mutableStateOf("0")
    var fittingFullFrameSunglass_HS by mutableStateOf("0")
    var fittingFullFrameSunglass_HD by mutableStateOf("0")
//  -----------------------------------------------------------------
    var fittingSupraNormal_LS by mutableStateOf("0")
    var fittingSupraNormal_LD by mutableStateOf("0")
    var fittingSupraNormal_HS by mutableStateOf("0")
    var fittingSupraNormal_HD by mutableStateOf("0")
    var fittingSupraPR_LS by mutableStateOf("0")
    var fittingSupraPR_LD by mutableStateOf("0")
    var fittingSupraPR_HS by mutableStateOf("0")
    var fittingSupraPR_HD by mutableStateOf("0")
    var fittingSupraSunglass_LS by mutableStateOf("0")
    var fittingSupraSunglass_LD by mutableStateOf("0")
    var fittingSupraSunglass_HS by mutableStateOf("0")
    var fittingSupraSunglass_HD by mutableStateOf("0")
//  -----------------------------------------------------------------
    var fittingRimlessNormal_LS by mutableStateOf("0")
    var fittingRimlessNormal_LD by mutableStateOf("0")
    var fittingRimlessNormal_HS by mutableStateOf("0")
    var fittingRimlessNormal_HD by mutableStateOf("0")
    var fittingRimlessPR_LS by mutableStateOf("0")
    var fittingRimlessPR_LD by mutableStateOf("0")
    var fittingRimlessPR_HS by mutableStateOf("0")
    var fittingRimlessPR_HD by mutableStateOf("0")
    var fittingRimlessSunglass_LS by mutableStateOf("0")
    var fittingRimlessSunglass_LD by mutableStateOf("0")
    var fittingRimlessSunglass_HS by mutableStateOf("0")
    var fittingRimlessSunglass_HD by mutableStateOf("0")
    var fittingRimlessPoly_LS by mutableStateOf("0")
    var fittingRimlessPoly_LD by mutableStateOf("0")
    var fittingRimlessPoly_HS by mutableStateOf("0")
    var fittingRimlessPoly_HD by mutableStateOf("0")
    var fittingRimlessPolyPR_LS by mutableStateOf("0")
    var fittingRimlessPolyPR_LD by mutableStateOf("0")
    var fittingRimlessPolyPR_HS by mutableStateOf("0")
    var fittingRimlessPolyPR_HD by mutableStateOf("0")
//  -----------------------------------------------------------------


    var orderId by mutableIntStateOf(123)
        private set
    var orderedShopName by mutableStateOf("ABC Specs")
        private set
    var orderType by mutableStateOf("Regular")
        private set
    var orderTime by mutableStateOf("09:17 a.m.")
        private set
    var paymentStatus by mutableStateOf("COD")
        private set

    var getFittingChargesResponseError by mutableStateOf("TEST")
        private set

    var geShiftingChargesResponseError by mutableStateOf("TEST")
        private set

    init {
        getShopsList()
        getShiftingCharges()
        getFittingCharges()
    }

    fun verifyAdmin(
        id: Int,
        pass: String
    ) {
        val adminVerification = AdminLoginBody(
            adminId = id,
            password = pass
        )
        viewModelScope.launch {
            try {
                val adminResponse = _lenzService.getAdminLogin(adminVerification)
                adminConfirmation = adminResponse.confirmation
            } catch (e: Exception) {
                adminConfirmation = false
            }
        }
    }

    fun getShopsList() {
        viewModelScope.launch {
            try {
                val shopsResponse = _lenzService.getShops()
                shopsList = shopsResponse
            } catch (e: Exception) {
                shopsList = emptyList()
            }
        }
    }

    fun getShiftingCharges() {
        viewModelScope.launch {
            try {
                val shiftingChargesResponse = _lenzService.getShiftingCharges()
                shiftingFullFrameCharges = shiftingChargesResponse.data.fullFrame.toString()
                shiftingSupraCharges = shiftingChargesResponse.data.supra.toString()
                shiftingRimLessCharges = shiftingChargesResponse.data.rimless.toString()
            } catch (e: HttpException) {
                geShiftingChargesResponseError = "An Exception Occurred : $e"
                shiftingFullFrameCharges = "-1"
                shiftingSupraCharges = "-1"
                shiftingRimLessCharges = "-1"
            }
        }
    }

    fun updateShiftingCharges() {
        val updatedShiftingCharges = ShiftingChargesUpdated(
            FullFrame = shiftingFullFrameCharges.toInt(),
            Rimless = shiftingRimLessCharges.toInt(),
            Supra = shiftingSupraCharges.toInt()
        )
        viewModelScope.launch {
            try {
                val shiftingUpdateResponse =
                    _lenzService.updateShiftingCharges(updatedShiftingCharges)
                shiftingUpdateConfirmation = shiftingUpdateResponse.confirmation
            } catch (e: Exception) {
                shiftingUpdateConfirmation = false
            }
        }
    }

    fun getFittingCharges() {
        viewModelScope.launch {
            try {
                val fittingChargesResponse = _lenzService.getFittingCharges()
                processFittingChargesResponse(fittingChargesResponse)
            } catch (e: Exception) {
                getFittingChargesResponseError = "An Exception Occurred : $e"
            }
        }
    }

    private fun processFittingChargesResponse(fittingChagresResponse: FittingChagresResponse) {
        fittingFullFrameNormal_LS = fittingChagresResponse.data.fullFrame.normal.low.single.toString()
        fittingFullFrameNormal_LD = fittingChagresResponse.data.fullFrame.normal.low.double.toString()
        fittingFullFrameNormal_HS = fittingChagresResponse.data.fullFrame.normal.high.single.toString()
        fittingFullFrameNormal_HD = fittingChagresResponse.data.fullFrame.normal.high.double.toString()
        fittingFullFramePR_LS = fittingChagresResponse.data.fullFrame.pr.low.single.toString()
        fittingFullFramePR_LD = fittingChagresResponse.data.fullFrame.pr.low.double.toString()
        fittingFullFramePR_HS = fittingChagresResponse.data.fullFrame.pr.high.single.toString()
        fittingFullFramePR_HD = fittingChagresResponse.data.fullFrame.pr.high.double.toString()
        fittingFullFrameSunglass_LS = fittingChagresResponse.data.fullFrame.sunglass.low.single.toString()
        fittingFullFrameSunglass_LD = fittingChagresResponse.data.fullFrame.sunglass.low.double.toString()
        fittingFullFrameSunglass_HS = fittingChagresResponse.data.fullFrame.sunglass.high.single.toString()
        fittingFullFrameSunglass_HD = fittingChagresResponse.data.fullFrame.sunglass.high.double.toString()

        fittingSupraNormal_LS = fittingChagresResponse.data.supra.normal.low.single.toString()
        fittingSupraNormal_LD = fittingChagresResponse.data.supra.normal.low.double.toString()
        fittingSupraNormal_HS = fittingChagresResponse.data.supra.normal.high.single.toString()
        fittingSupraNormal_HD = fittingChagresResponse.data.supra.normal.high.double.toString()
        fittingSupraPR_LS = fittingChagresResponse.data.supra.pr.low.single.toString()
        fittingSupraPR_LD = fittingChagresResponse.data.supra.pr.low.double.toString()
        fittingSupraPR_HS = fittingChagresResponse.data.supra.pr.high.single.toString()
        fittingSupraPR_HD = fittingChagresResponse.data.supra.pr.high.double.toString()
        fittingSupraSunglass_LS = fittingChagresResponse.data.supra.sunglass.low.single.toString()
        fittingSupraSunglass_LD = fittingChagresResponse.data.supra.sunglass.low.double.toString()
        fittingSupraSunglass_HS = fittingChagresResponse.data.supra.sunglass.high.single.toString()
        fittingSupraSunglass_HD = fittingChagresResponse.data.supra.sunglass.high.double.toString()

        fittingRimlessNormal_LS = fittingChagresResponse.data.rimless.normal.low.single.toString()
        fittingRimlessNormal_LD = fittingChagresResponse.data.rimless.normal.low.double.toString()
        fittingRimlessNormal_HS = fittingChagresResponse.data.rimless.normal.high.single.toString()
        fittingRimlessNormal_HD = fittingChagresResponse.data.rimless.normal.high.double.toString()
        fittingRimlessPR_LS = fittingChagresResponse.data.rimless.pr.low.single.toString()
        fittingRimlessPR_LD = fittingChagresResponse.data.rimless.pr.low.double.toString()
        fittingRimlessPR_HS = fittingChagresResponse.data.rimless.pr.high.single.toString()
        fittingRimlessPR_HD = fittingChagresResponse.data.rimless.pr.high.double.toString()
        fittingRimlessSunglass_LS = fittingChagresResponse.data.rimless.sunglass.low.single.toString()
        fittingRimlessSunglass_LD = fittingChagresResponse.data.rimless.sunglass.low.double.toString()
        fittingRimlessSunglass_HS = fittingChagresResponse.data.rimless.sunglass.high.single.toString()
        fittingRimlessSunglass_HD = fittingChagresResponse.data.rimless.sunglass.high.double.toString()
        fittingRimlessPoly_LS = fittingChagresResponse.data.rimless.poly.low.single.toString()
        fittingRimlessPoly_LD = fittingChagresResponse.data.rimless.poly.low.double.toString()
        fittingRimlessPoly_HS = fittingChagresResponse.data.rimless.poly.high.single.toString()
        fittingRimlessPoly_HD = fittingChagresResponse.data.rimless.poly.high.double.toString()
        fittingRimlessPolyPR_LS = fittingChagresResponse.data.rimless.polyPR.low.single.toString()
        fittingRimlessPolyPR_LD = fittingChagresResponse.data.rimless.polyPR.low.double.toString()
        fittingRimlessPolyPR_HS = fittingChagresResponse.data.rimless.polyPR.high.single.toString()
        fittingRimlessPolyPR_HD = fittingChagresResponse.data.rimless.polyPR.high.double.toString()
    }

    fun updateFittingCharges() {
        val updatedFullFrame = FittingDataFullFrame(
            normal = LowHigh(
                low = SingleDouble(
                    single = fittingFullFrameNormal_LS.toInt(),
                    double = fittingFullFrameNormal_LD.toInt()
                ),
                high = SingleDouble(
                    single = fittingFullFrameNormal_HS.toInt(),
                    double = fittingFullFrameNormal_HD.toInt()
                )
            ),
            pr = LowHigh(
                low = SingleDouble(
                    single = fittingFullFramePR_LS.toInt(),
                    double = fittingFullFramePR_LD.toInt()
                ),
                high = SingleDouble(
                    single = fittingFullFramePR_HS.toInt(),
                    double = fittingFullFramePR_HD.toInt()
                )
            ),
            sunglass = LowHigh(
                low = SingleDouble(
                    single = fittingFullFrameSunglass_LS.toInt(),
                    double = fittingFullFrameSunglass_LD.toInt()
                ),
                high = SingleDouble(
                    single = fittingFullFrameSunglass_HS.toInt(),
                    double = fittingFullFrameSunglass_HD.toInt()
                )
            )
        )
        val updatedSupra = FittingDataSupra(
            normal = LowHigh(
                low = SingleDouble(
                    single = fittingSupraNormal_LS.toInt(),
                    double = fittingSupraNormal_LD.toInt()
                ),
                high = SingleDouble(
                    single = fittingSupraNormal_HS.toInt(),
                    double = fittingSupraNormal_HD.toInt()
                )
            ),
            pr = LowHigh(
                low = SingleDouble(
                    single = fittingSupraPR_LS.toInt(),
                    double = fittingSupraPR_LD.toInt()
                ),
                high = SingleDouble(
                    single = fittingSupraPR_HS.toInt(),
                    double = fittingSupraPR_HD.toInt()
                )
            ),
            sunglass = LowHigh(
                low = SingleDouble(
                    single = fittingSupraSunglass_LS.toInt(),
                    double = fittingSupraSunglass_LD.toInt()
                ),
                high = SingleDouble(
                    single = fittingSupraSunglass_HS.toInt(),
                    double = fittingSupraSunglass_HD.toInt()
                )
            )
        )
        val updatedRimless = FittingDataRimless(
            normal = LowHigh(
                low = SingleDouble(
                    single = fittingRimlessNormal_LS.toInt(),
                    double = fittingRimlessNormal_LD.toInt()
                ),
                high = SingleDouble(
                    single = fittingRimlessNormal_HS.toInt(),
                    double = fittingRimlessNormal_HD.toInt()
                )
            ),
            pr = LowHigh(
                low = SingleDouble(
                    single = fittingRimlessPR_LS.toInt(),
                    double = fittingRimlessPR_LD.toInt()
                ),
                high = SingleDouble(
                    single = fittingRimlessPR_HS.toInt(),
                    double = fittingRimlessPR_HD.toInt()
                )
            ),
            poly = LowHigh(
                low = SingleDouble(
                    single = fittingRimlessPoly_LS.toInt(),
                    double = fittingRimlessPoly_LD.toInt()
                ),
                high = SingleDouble(
                    single = fittingRimlessPoly_HS.toInt(),
                    double = fittingRimlessPoly_HD.toInt()
                )
            ),
            polyPR = LowHigh(
                low = SingleDouble(
                    single = fittingRimlessPolyPR_LS.toInt(),
                    double = fittingRimlessPolyPR_LD.toInt()
                ),
                high = SingleDouble(
                    single = fittingRimlessPolyPR_HS.toInt(),
                    double = fittingRimlessPolyPR_HD.toInt()
                )
            ),
            sunglass = LowHigh(
                low = SingleDouble(
                    single = fittingRimlessSunglass_LS.toInt(),
                    double = fittingRimlessSunglass_LD.toInt()
                ),
                high = SingleDouble(
                    single = fittingRimlessSunglass_HS.toInt(),
                    double = fittingRimlessSunglass_HD.toInt()
                )
            )
        )

        val updatedFittingChargesData = UpdatedFittingChargesData(
            FittingChargesData(
                fullFrame = updatedFullFrame,
                supra = updatedSupra,
                rimless = updatedRimless
            )
        )

        viewModelScope.launch {
            try {
                val fittingUpdateResponse =
                    _lenzService.updateFittingCharges(updatedFittingChargesData)
                fittingUpdateConfirmation = fittingUpdateResponse.confirmation
            } catch (e: Exception) {
                fittingUpdateConfirmation = false
            }
        }
    }
}