def print_diamond(n):
    if n %2 == 0 :
        raise ValueError("Number must be odd")
    
    for i in range (n):
        if i%2 == 0:
            print(''*((n-i-1)//2)+'.'*(i+1))
    
    for i in range (n-2, -1, -1):
        if i%2 == 0:
            print(""*((n-i-1)//2)+"."*(i+1))


print (print_diamond(9))
class Bank_Account:
    def __init__(self, holder_name, account_number, balance):
        self.holder_name= holder_name
        self.account_number = account_number
        self.balance = balance

    def deposit(self, amount):
        if amount>0:
            self.balance +=amount
            print(f"Deposited: ${amount:.3f}")
        else: 
            print(f"Deposit must be positive!")

    def withdraw(self, amount):
        if (amount>0):
            if (self.balance>=amount):
                self.balance -= amount
                print(f"Withdrew: ${amount:.1f}")
            else:
                print("Insufficient funds")
        else :
            print("Withdrawal amount invalid")
    
    def get_balance(self):
        return f"Current balance: ${self.balance}"
    
    def account_info(self):
        return (f"Account Holder: ${self.holder_name}\n"
                f"Account Number: ${self.account_number}\n"
                f"Balance: ${self.balance}")
    

account = Bank_Account("Terrence Wiliam","89912311",10)
account.deposit(50)
account.withdraw(40)
account.withdraw(20)
# print(account.account_info())