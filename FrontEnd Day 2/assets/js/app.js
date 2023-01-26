
function SendRequest(){
    fetch('https://fakestoreapi.com/products')
    .then(res=>res.json())
    .then(data=>{
        let list = '';
        let word='';
        data.forEach(element => {
            list+=`
            <div class="product">
            <div class="image">
                <img src=${element.image} alt="">
                </div>
                </div>
        
    `})
           
        document.querySelector('.products').innerHTML = list
    })
    .catch(error=>console.log(error))
    }


    function ShowCategory(){
        //fetch('https://fakestoreapi.com/products/categories')


      
        fetch('https://fakestoreapi.com/products/categories')
        .then(res=>res.json())
        .then(data=>{ 
           let list='CATEGORIES: ';
           data.forEach(element=>{
             list+=`<div class= 'category'>${element}</div>
            ` })
         document.querySelector('.categories').innerHTML = list;
        
        } )
               
           
    
        .catch(error=>console.log(error))
        }

        ShowCategory()

        SendRequest()
