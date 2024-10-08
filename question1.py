def valid_palindrome(value:str)-> bool:
    # check if characters if non alphanumeric
    resultCharacter = ''.join(value.lower() for letter in value if letter.isalnum());
    #if final character the same as reverse then true else false
    return (resultCharacter==resultCharacter[::-1])

print(valid_palindrome('A man, a plan, a canal: Panama'));
print(valid_palindrome("race a car"));
print(valid_palindrome(""));