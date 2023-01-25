function getAllCategories(){

    let list = '';
    fetch('https://fakestoreapi.com/products/categories')
            .then(res=>res.json())
            .then(json=>{
                json.forEach(element => {
                        console.log(element)
                    list +=`
                    <div class="category">

                        <p>${element}</p>
                    
                    </div>
                     `
                })
                document.querySelector('.categories').innerHTML = list

            })
            .catch(error => console.log(error))
            
}

function getAllProducts(){
    let list = '';
    fetch('https://fakestoreapi.com/products')
    .then(res=>res.json())
    .then(json=>{

            json.forEach(element => {

                let price = element.price;
                let description = element.description;
                    

                    list +=`
                    <div class="item">
                    <div class="imagediv">
                         <img src="${element.image}" alt="">
                    </div>
                    <div class="bottom">
                        <h3>Məhsulun adı ${element.title}</h3>
                        <h5 class="price">Qiymət ${price} USD</h5>
                        <h5>İD = ${element.id}</h5>
                        <h5>Məlumat ${description}</h5>
        
                    </div>
        
                </div>
                     `
                })
                document.querySelector('.Products').innerHTML = list

            })
            .catch(error => console.log(error))
}
getAllCategories()
getAllProducts()