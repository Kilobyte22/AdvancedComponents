package de.kilobyte22.advcomponents.helpers

object ErrorHelper {
  def argError(argid: Int, expected: String) = {
    val argnum = argid + 1
    s"bad argument #$argnum: $expected expected"
  }

  def argError(argid: Int, expected: String, got: String) = {
    val argnum = argid + 1
    s"bad argument #$argnum: $expected expected, got $got"
  }
}
