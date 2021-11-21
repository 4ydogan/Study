import re

input = open('tweets.txt', 'r', encoding="utf-8")
Lines = input.readlines()

print("Input dosyasi acildi ve tweetler okundu.")

output = open('preprocessed_tweets.txt', 'w', encoding="utf-8")

chars = ':./?;,“”"\''

for line in Lines:
    Words = line.split()
    for word in Words:
        if word[0] != '@':
            result = re.fullmatch(".+[0-9:./,?']+[a-zA-Z].+", word)
            if result == None:
                for ch in chars:
                    if ch in word:
                        word = word.replace(ch, '')
                output.write(word)
                output.write(' ')
    output.write('\n')

input.close()

print("Duzenlenen satirlar output dosyasina yazildi ve dosyalar kapandi.")

