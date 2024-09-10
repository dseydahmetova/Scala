case class Address(`type`: String, value: String) {
  def toStringAddress = s"${`type`}:$value"
}

