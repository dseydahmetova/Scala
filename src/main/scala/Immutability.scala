@main def Immutability(args: String*): Unit =
    println("-" * 50)

    final class ImmutableBankAccount(val balance: Int):
      def deposit(amount: Int): ImmutableBankAccount =
        ImmutableBankAccount(balance + amount)

      def withdraw(amount: Int): ImmutableBankAccount =
        ImmutableBankAccount(balance - amount)

    val firstBankAccount = ImmutableBankAccount(balance = 100)
    println(firstBankAccount.balance)
    val secondBankAccount = firstBankAccount.deposit(amount = 50)
    println(secondBankAccount.balance)
    val thirdBankAccount = secondBankAccount.withdraw(amount = 15)
    println(thirdBankAccount.balance)

    println("-" * 50)
//    we can modify it
    val bankAccount = ImmutableBankAccount(balance = 0)
      .deposit(amount = 20)
      .withdraw(amount = 5)

    println(bankAccount.balance)






