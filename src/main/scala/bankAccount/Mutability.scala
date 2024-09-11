package bankAccount

@main def Mutability(args: String*): Unit =
  println("-" * 50)

//  let's say we have function f and g
// g takes a, and f takes g => f(g(a))
// g(a).pipe(f) or a.pipe(g).pipe(f)

  extension[A](self: A)
    def pipe[B](f: A => B): B =
      f(self)

    def tap[B](f: A => B): A =
      f(self)

      self

  final class MutableBankAccount(initialBalance: Int):
    private var currentBalance: Int =
      initialBalance

    def balance: Int =
      currentBalance

    def deposit(amount: Int): Unit =
      currentBalance += amount

    def withdraw(amount: Int): Unit =
      currentBalance -= amount

    override def toString: String =
      s"MutableBankAccount($balance)"


  val firstBankAccount = MutableBankAccount(initialBalance = 100)

  println(firstBankAccount.balance)
  firstBankAccount.deposit(amount = 20)
  println(firstBankAccount.balance)
  firstBankAccount.withdraw(amount = 70)
  println(firstBankAccount.balance)

  println("-" * 50)
//    we can modify it
  val bankAccount =
    val result = MutableBankAccount(initialBalance = 0)
    result.deposit(amount = 20)
    result.withdraw(amount = 5)

    result
  println(bankAccount.balance)

  println("-" * 50)
//    we can modify it
    val bankAccount1 = MutableBankAccount(initialBalance = 0)
      .tap(_.deposit(amount = 20))
      .tap(_.withdraw(amount = 5))

  println(bankAccount1.balance)

  println("-" * 50)
//    we can modify it using tuples
  val e = {println("producing 1"); MutableBankAccount(1)}
  // e.withdraw(amount = 1)
  //  we can also write it this way,
  //  shortened from e.pipe(e => e.withdraw(amount = 1))
    e.pipe(_.withdraw(amount = 1))

  val te = (e, e)
  println(te)

  println("-" * 50)
  val f = {println("producing 1"); MutableBankAccount(1)}
  // f.withdraw(amount = 1)

  val tf = (
    {println("producing 1"); MutableBankAccount(1)},
    {println("producing 1"); MutableBankAccount(1)},
  )
  println(tf)

  println("-" * 50)
  // using description
  val ee = () =>  {println("producing 1"); MutableBankAccount(1)}



