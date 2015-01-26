package com.IMIHOF.MineData

import spray.http.DateTime

abstract class Data {
    def raw: String
    def solvedCount: Int
}

abstract class SubmitResult {
    def date: DateTime
    
    class SubmitStatus extends Enumeration {
        type SubmitStatus = Value
        val Success, TimeLimit, MemoryLimit, WrongAnswer = Value
    }
    
    def status: SubmitStatus
    def attempt: Int
}