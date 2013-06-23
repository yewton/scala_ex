package net.yewton.exercise.scala.ex15

abstract class Expr
case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String, lhs: Expr, rhs: Expr) extends Expr
