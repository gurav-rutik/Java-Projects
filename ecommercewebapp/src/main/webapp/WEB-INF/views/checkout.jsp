<html>
<head>
    <title>Checkout</title>
    <link rel="stylesheet" href="styles.css">
    <style>
        body { font-family: Arial, sans-serif; }
        .checkout-container { width: 50%; margin: auto; padding: 20px; background: #f9f9f9; border-radius: 10px; }
        .checkout-container input, .checkout-container button { width: 100%; margin: 10px 0; padding: 10px; }
    </style>
</head>
<body>
    <div class="checkout-container">
        <h2>Checkout</h2>
        <form action="confirmOrder" method="post">
            <input type="text" name="address" placeholder="Shipping Address" required>
            <input type="text" name="payment" placeholder="Payment Details" required>
            <button type="submit">Place Order</button>
        </form>
    </div>
</body>
</html>