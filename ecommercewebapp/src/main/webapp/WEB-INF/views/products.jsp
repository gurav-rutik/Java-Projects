<html>
<head>
    <title>Products</title>
    <link rel="stylesheet" href="styles.css">
    <style>
        body { font-family: Arial, sans-serif; }
        .product { display: flex; flex-direction: column; align-items: center; border: 1px solid #ccc; border-radius: 10px; padding: 20px; margin: 20px; transition: transform 0.3s; }
        .product:hover { transform: scale(1.05); }
        .product img { max-width: 100%; border-radius: 10px; }
        .product h3 { margin: 10px 0; }
        .product button { padding: 10px; background-color: #007BFF; color: white; border: none; border-radius: 5px; cursor: pointer; transition: background-color 0.3s; }
        .product button:hover { background-color: #0056b3; }
    </style>
</head>
<body>
    <h1>Our Products</h1>
    <div class="product">
        <img src="product1.jpg" alt="Product 1">
       <h3>Product 1</h3>
        <p>$10.00</p>
        <button>Add to Cart</button>
    </div>
    <!-- Add Java logic to dynamically load products -->
</body>
</html>