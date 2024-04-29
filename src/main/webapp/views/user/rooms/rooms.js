const userOptions = document.getElementById("user_options")
const QuantityPerson = document.getElementsByClassName("QuantityPerson")[0]
const optionItem = document.getElementsByClassName("option__item") 

userOptions.addEventListener("focus", ()=>{
    QuantityPerson.classList.add("QuantityPerson__show")
})

userOptions.addEventListener("blur", ()=>{
    QuantityPerson.classList.remove("QuantityPerson__show")
})

for (let i = 0; i < optionItem.length; i++) {
    optionItem[i].addEventListener("click", ()=>{
        optionItem[i].classList.toggle("choose__option")
    })
}