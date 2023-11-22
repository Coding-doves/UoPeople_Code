def try_exc(doc):
    try:
        # open a file for reading
        with open(doc, 'r') as file:
            content = file.read()
        print("\nFile content:", content)

    except FileNotFoundError as e:
        # Handle exception: if file is not found
        print(f"\nError: {e}\n")
        print(f"{doc} file not found. Please check the file name.\n")
    except Exception as e:
        # Handle any other exceptions that may occur
        print(f"Error: {e}\n")
        print("An unexpected error occurred.\n")

try_exc('Unit8-dictFile')
