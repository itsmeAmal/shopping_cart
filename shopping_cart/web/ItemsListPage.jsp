<%-- 
    Document   : ItemsListPage
    Created on : Oct 3, 2020, 9:51:30 AM
    Author     : personal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Items</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <style>
            .button {
                background-color: #4CAF50; /* Green */
                border: none;
                color: white;
                padding: 20px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 16px;
                margin: 4px 2px;
                cursor: pointer;
            }
            .button2 {border-radius: 4px;}
        </style>
    </head>
    <body>
        <form action="AddToCartServletController">
            <div class="w3-container w3-teal">
                <h1>Items</h1>
            </div>
            <div class="w3-container">
                <h2>Add Items To Cart</h2>
                <ul class="w3-ul w3-card-4">
                    <li class="w3-bar">
                        <span onclick="this.parentElement.style.display = 'none'" class="w3-bar-item w3-button w3-white w3-xlarge w3-right">×</span>
                        <img src="img_avatar2.png" class="w3-bar-item w3-circle w3-hide-small" style="width:85px">
                        <input type="submit" class="button button2" value="Add To Cart">
                        <div class="w3-bar-item">
                            <span class="w3-large">Item 1</span><br>
                            Rs <span>1500.00</span>
                            <input type="hidden" name="item_1" value="1500.00"/>
                            <input type="hidden" name="value_1" value="1500.00"/>
                        </div><br>
                        <input class="w3-input w3-border" name="qty_1" type="text" style="position: relative; width: 100px; left: 210px" placeholder="Qty" >
                    </li>

                    <li class="w3-bar">
                        <span onclick="this.parentElement.style.display = 'none'" class="w3-bar-item w3-button w3-white w3-xlarge w3-right">×</span>
                        <img src="img_avatar5.png" class="w3-bar-item w3-circle w3-hide-small" style="width:85px">
                        <input type="submit" class="button button2" value="Add To Cart">
                        <div class="w3-bar-item">
                            <span class="w3-large">Item 2</span><br>
                            Rs <span>1800.00</span>
                            <input type="hidden" name="item_2" value="1800.00"/>
                            <input type="hidden" name="value_2" value="1800.00"/>
                        </div><br>
                        <input class="w3-input w3-border" name="qty_2" type="text" style="position: relative; width: 100px; left: 210px" placeholder="Qty">
                    </li>

                    <li class="w3-bar">
                        <span onclick="this.parentElement.style.display = 'none'" class="w3-bar-item w3-button w3-white w3-xlarge w3-right">×</span>
                        <img src="img_avatar6.png" class="w3-bar-item w3-circle w3-hide-small" style="width:85px">
                        <input type="submit" class="button button2" value="Add To Cart">
                        <div class="w3-bar-item">
                            <span class="w3-large">Item 3</span><br>
                            Rs <span>750.00</span>
                            <input type="hidden" name="item_3" value="750.00"/>
                            <input type="hidden" name="value_3" value="750.00"/>
                        </div><br>
                        <input class="w3-input w3-border" name="qty_3" type="text" style="position: relative; width: 100px; left: 210px" placeholder="Qty">
                    </li>
                </ul>
            </div>
            <div style="position: absolute; left: 70%; top: 13%; width: 32px; height: 32px;">
                <input class="w3-input w3-border" name="qty_3" type="text" style="position: relative; width: 100px; left: 210px" placeholder="Qty">
                
            </div>
            
        </form>
    </body>
</html>
