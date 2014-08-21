package model.accounts

abstract class AccountsList{
  def getAll: List[String]
}

object CodeforcesAccountsList extends AccountsList {
  def getAll = List("Katan", "Katann", "kostya1996")
}

