The code compares each character to it's corresponding character on the other side of the string. For example, it compares the first character to the last character, then the second character to the second to last character. If they are not the same, it returns false. If it gets to the half way point, it returns true. O(n) time.

It also removes non alphanumeric characters before this and changes the string to all lowercase.
