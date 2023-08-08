# Enter your own number in the list
num_list = list(input("Enter your own list with comma separated values: ").split(", "))

# Get first element in list
list_first = num_list[0]

# Get last element in list
list_last = num_list[-1]

# Check if first and last element are equal
if (list_first == list_last):
    print(True)
else:
    print(False)