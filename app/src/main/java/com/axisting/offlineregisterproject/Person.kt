package com.axisting.offlineregisterproject

class Person {

    var age  : Int
    var name : String
    var job : String
    public  var hairColor : String = ""

    constructor (ageInput : Int , nameInput : String , jobInput : String  ) {
        this.age = ageInput
        this.name = nameInput
        this.job = jobInput
    }



}