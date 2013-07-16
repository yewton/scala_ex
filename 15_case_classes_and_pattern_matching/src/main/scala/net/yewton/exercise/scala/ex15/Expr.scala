package net.yewton.exercise.scala.ex15

object Expr {
  def simplifyTop(expr: Expr): Expr = expr match {
    case UnOp("-", UnOp("-", e))  => e // -(-e) = e
    case BinOp("+", e, Number(0)) => e // e + 0 = e
    case BinOp("*", e, Number(1)) => e // e * 1 = e
    case _ => expr
  }
}

abstract class Expr
case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String, lhs: Expr, rhs: Expr) extends Expr
