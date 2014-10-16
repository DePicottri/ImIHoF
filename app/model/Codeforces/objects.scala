package com.codeforces.api.objects

case class Member(
  handle: String)

case class Problem(
  contestId: Int,
  index: String,
  name: String,
  `type`: String,
  points: Option[Double],
  tags: List[String])

case class Party(
  contestId: Int,
  members: List[Member],
  participantType: String,
  teamId: Option[Int],
  teamName: Option[String],
  ghost: Boolean,
  room: Option[Int],
  startTimeSeconds: Option[Int])

case class Submission(
  id: Int,
  contestId: Int,
  creationTimeSeconds: Long,
  relativeTimeSeconds: Long,
  problem: Problem,
  author: Party,
  programmingLanguage: String,
  verdict: Option[String],
  testset: String,
  passedTestCount: Int,
  timeConsumedMillis: Int,
  memoryConsumedBytes: Int)

case class StatusResponce(
  status: String,
  result: List[Submission])

