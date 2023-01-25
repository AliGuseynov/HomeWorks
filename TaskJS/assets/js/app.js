let button = document.getElementById("btn")


function getCatagories() {

    fetch('https://fakestoreapi.com/products/categories')
        .then(res => res.json())
        .then(data => {

            let listCategories = '';

            data.forEach(element => {
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

function getProducts() {

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








