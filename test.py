import math

def round_tax(amount):
    return math.ceil(amount/2)

def calculate_tax(price_amount, basic_tax_rate, import_duty_rate):
    basic_tax = basic_tax_rate*price_amount
    import_duty = import_duty_rate*price_amount
    total_tax = basic_tax+ import_duty
    final_tax = round_tax(total_tax)
    return final_tax

def process_receipt(items):
    total_sales_tax= 0
    total_price=0
    item_details=[]

    for count in items:
        quantity, description, price = count["quantity"], count["description"], count["price"]
        is_imported = 'imported' in description
        is_exempt = any(exempt in description for exempt in ["book", "chocolate","pills"])

        basic_tax_rate = 0 if is_exempt else 0.10
        import_duty_rate = 0.05 if is_imported else 0
    
        tax=calculate_tax(price,basic_tax_rate, import_duty_rate)
        final_price = price+tax

        total_sales_tax +=tax
        total_price +=final_price
        item_details.append(f"{quantity} {description}: {final_price:.2f}")

    return item_details, total_sales_tax, total_price  

def print_receipt(items):
    item_details, total_sales_tax, total_price = process_receipt(items)
    for detail in item_details:
        print(detail)
    print(f"Sales Taxes: {total_sales_tax:.2f}\n"+
        f"Total: {total_price:.2f}")
    

input1 = [
    {'quantity': 1, 'description': 'book', 'price': 12.49},
    {'quantity': 1, 'description': 'music CD', 'price': 14.99},
    {'quantity': 1, 'description': 'chocolate bar', 'price': 0.85}
]

input2 = [
    {'quantity': 1, 'description': 'imported box of chocolates', 'price': 10.00},
    {'quantity': 1, 'description': 'imported bottle of perfume', 'price': 47.50}
]

input3 = [
    {'quantity': 1, 'description': 'imported bottle of perfume', 'price': 27.99},
    {'quantity': 1, 'description': 'bottle of perfume', 'price': 18.99},
    {'quantity': 1, 'description': 'packet of headache pills', 'price': 9.75},
    {'quantity': 1, 'description': 'imported box of chocolates', 'price': 11.25}
]

print("Output 1:")
print_receipt(input1)
print("Output 2:")
print_receipt(input2)
print("Output 3:")
print_receipt(input3)