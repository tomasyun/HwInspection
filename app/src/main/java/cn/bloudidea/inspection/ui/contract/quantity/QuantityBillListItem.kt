package cn.bloudidea.inspection.ui.contract.quantity

data class QuantityBillListItem(
    val quantityBillNo: String,
    val billName: String,
    val unit: String,
    val contractCount: String,
    val contractAccount: String,
    val auditCount: String,
    val auditAccount: String,
    val parentBill: String,
    val levelType: String
)
