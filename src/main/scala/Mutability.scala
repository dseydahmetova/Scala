@main def Mutability(args: String*): Unit =
  println("-" * 50)

  final class MutableBankAccount(initialBalance: Int):
    private var currentBalance: Int =
      initialBalance

    def balance: Int =
      currentBalance

    def deposit(amount: Int): Unit =
      currentBalance += amount

    def withdraw(amount: Int): Unit =
      currentBalance -= amount

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

