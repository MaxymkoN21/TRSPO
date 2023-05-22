/**
 Enum representing the different status of an order.
 The possible status of an order are:
 • NOT_PAID: The order has not been paid yet.
 • PENDING: The order has been paid but not yet confirmed.
 • PAID: The order has been paid and confirmed.
 • CONFIRMED: The order has been confirmed and sent to the kitchen for execution.
 • CANCELLED: The order has been cancelled.
 */

package lab3.Enums;

public enum OrderStatus {
//    NOT_PAID,
//    PENDING,
//    PAID,
//    CONFIRMED,
//    CANCELLED
    WAITING,
    ACCEPTED,
    INPROGRESS,
    RECEIVED,
    PAID
}
