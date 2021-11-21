import re

input = open('sentences.txt', 'r', encoding="utf-8")
Lines = input.readlines()

print("Input dosyasi acildi ve cumleler okundu.")

output = open('sentences_output.txt', 'w', encoding="utf-8")

for line in Lines:
    valid = 0

    double_quote = re.findall('".*"', line)

    if double_quote != []:
        end = len(str(double_quote))
        line = line.replace(str(double_quote)[2:end-2], "")

    only_one = re.match(".*[\.\?!] [A-Z].*", line)
    begin_capital = re.match("^[A-Z].*", line)
    both_letter = re.match(".*[0-9][a-zA-Z].*", line)
    both_number = re.match(".*[a-zA-Z][0-9].*", line)
    ends_comma = re.match(",$", line)
    no_middle_aA = re.match(".*[a-z][A-Z].*", line)
    no_middle_Aa = re.match(".*[A-Z]*[a-z]+[A-Z]+.*", line)
    punctuation = re.match(".* [\.\?!,].*", line)

    if only_one == None:
        if begin_capital != None:
            if both_letter == None and both_number == None:
                if ends_comma == None:
                    if no_middle_aA == None and no_middle_Aa == None:
                        if punctuation == None:
                            valid = 1

    if valid == 0:
        output.write('not valid\n')
    else:
        output.write('valid\n')

input.close()
output.close()

print("Degerler output dosyasina yazildi ve dosyalar kapandi.")
