1 POST - http://localhost:8080/api/placeOrder

Request Payload
{ "orderDescription": "Test Order Description",

 "cartItems": [
     {
         "productId": 1,
         "quantity": 2
     },
     {
         "productId": 3,
         "quantity": 7
     }
 ],
 "customerEmail": "abcd@gmail.com",
 "customerName": "Anand Dubey"
}

Response

{ "amount": 109794.0, "invoiceNumber": 679, "date": "22-07-2022 23:16:40", "orderId": 1, "orderDescription": "This order is for my friend's Marriage" }
