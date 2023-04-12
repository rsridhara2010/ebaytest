Validation Service implemented using Springboot & jdk 17 on Intellij IDE

Test Cases:


curl --location --request POST 'localhost:8080/challenge/validate' \
--header 'Content-Type: application/json' \
--data-raw '{
"siteId":"1",
"categoryId":"2",
"title":"Nike Shoes",
"quantity": -1,
"imageURL": ["www.ebay.com"],
"description": "Nike Shoes Description",
"condition": "NEW",
"itemSpecifics": ["Nike Specific"],
"price": -1
}'

returns: 404:
[
{
"message": "Invalid Qty",
"code": 1
},
{
"message": "Invalid Price",
"code": 2
}
]



curl --location --request POST 'localhost:8080/challenge/validate' \
--header 'Content-Type: application/json' \
--data-raw '{
"siteId":"1",
"categoryId":"2",
"title":"Nike Shoes",
"quantity": -1,
"imageURL": ["www.ebay.com"],
"description": "Nike Shoes Description",
"condition": "USED",
"itemSpecifics": ["Nike Specific"],
"price": -1
}'

returns 200 OK 
