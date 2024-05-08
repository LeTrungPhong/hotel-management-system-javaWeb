const userOptions = document.getElementById("user_options")
const QuantityPerson = document.getElementsByClassName("QuantityPerson")[0]
const optionItem = document.getElementsByClassName("option__item") 
const subPerson = document.getElementsByClassName("QuantityPerson__operator__sub")
const addPerson = document.getElementsByClassName("QuantityPerson__operator__plus")
const QuantityPersonAmount = document.getElementsByClassName("QuantityPerson__amount")
const findSuitableRoom = document.getElementById("findSuitableRoom")
const buttonSearch = document.getElementsByClassName("button_search")[0]

var PhongNgu = true

for (let i = 0; i < subPerson.length; i++) {
    subPerson[i].addEventListener("click", ()=>{
        userOptions.focus()
        if(QuantityPersonAmount[i].innerText > 0){
            QuantityPersonAmount[i].innerText--
            userOptions.placeholder = QuantityPersonAmount[0].innerText + " adults, " + QuantityPersonAmount[1].innerText + " child"
        }
    })

    addPerson[i].addEventListener("click", ()=>{
        userOptions.focus()
        QuantityPersonAmount[i].innerText++
        userOptions.placeholder = QuantityPersonAmount[0].innerText + " adults, " + QuantityPersonAmount[1].innerText + " child"
    })
}

QuantityPerson.addEventListener("mousemove", ()=>{
    PhongNgu = true
})

QuantityPerson.addEventListener("mouseout", ()=>{
    PhongNgu = false
})

userOptions.addEventListener("focus", ()=>{
    QuantityPerson.classList.add("QuantityPerson__show")
})

userOptions.addEventListener("blur", ()=>{
    if(PhongNgu){
        return
    }
    QuantityPerson.classList.remove("QuantityPerson__show")
})

for (let i = 0; i < optionItem.length; i++) {
    optionItem[i].addEventListener("click", ()=>{
        optionItem[i].classList.toggle("choose__option")

    })
}

function getOption(){
    option = ""
    for (let i = 0; i < optionItem.length; i++) {
        if(optionItem[i].classList.contains("choose__option")){
            option+= optionItem[i].innerText + ", "
        }
    }
    return option
}

buttonSearch.addEventListener("click", ()=>{
    document.getElementById("option").value = getOption()
    document.getElementById("timePicker__start").value = document.getElementsByClassName("datepicker-input")[0].value
    document.getElementById("timePicker__end").value = document.getElementsByClassName("datepicker-input")[1].value
    document.getElementById("min-value").value = document.getElementById("slider-range-value1").innerText
    document.getElementById("max-value").value = document.getElementById("slider-range-value2").innerText
    document.getElementById("amongChild").value = QuantityPersonAmount[1].innerHTML
    document.getElementById("amongAdult").value = QuantityPersonAmount[0].innerHTML

    findSuitableRoom.submit()
})

