
let button = document.getElementById("btn")


function forCategories() {

    fetch('https://fakestoreapi.com/products/categories')
        .then(res => res.json())
        .then(data => {

            let listCategories = '';

            data.forEach(element => {
                // console.log(element)
                listCategories += `
                    
                    <div class="category">
                       <p>${element}</p>
                    </div>
                    `
            })

            document.querySelector("#categories").innerHTML = listCategories

        })
        .catch(error => console.log(error))
}

function forProducts() {

    fetch('https://fakestoreapi.com/products')
        .then(res => res.json())
        .then(data => {

            let listProducts = '';

            data.forEach(element => {
                listProducts += `
                    

                    <div class="product">
                    
                    <div class="p-img">
                   
                    <img src="${element.image}">

                    </div>
                    
                    <div class="p-description">
                    <p>
                    ${element.title} <br>
                    ${element.category} <br>
                    ${element.price}<br>
                    
                    </p>
                    
                    </div>

                    </div>
                    `
            })

            document.querySelector("#products").innerHTML = listProducts

        })
        .catch(error => console.log(error))
}





function sendRequest() {
    fetch('https://fakestoreapi.com/products')
        .then(res => res.json())
        .then(data => {
            let list = '';

            data.forEach(element => {
                console.log(element)
                list += `
                <div class="users">
                <div class="image">
                <img src="${element.image}">

                </div>

                <div class="user-detail">
                <p>${element.title} ${element.price}</p>
                </div>
                </div>
                
                `

            });

            document.querySelector("#allUser").innerHTML = list

        })

        .catch(error => console.log(error))



}