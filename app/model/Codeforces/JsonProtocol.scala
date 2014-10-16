package com.codeforces.api

import spray.json.DefaultJsonProtocol
import com.codeforces.api.objects._


object JsonProtocol extends DefaultJsonProtocol {
  implicit val memberFormat = jsonFormat1(Member)
  implicit val problemFormat = jsonFormat6(Problem)
  implicit val partyFormat = jsonFormat8(Party)
  implicit val submissionFormat = jsonFormat12(Submission)
  implicit val statucResultFormat = jsonFormat2(StatusResponce)
}