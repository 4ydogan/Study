file = open("link-23-01.txt", "r", encoding="utf-8")
linksFile = open("linksFile.txt", "w", encoding="utf-8")

Links = file.readlines()
print("Tüm satirlar okundu.")

for line in Links:
    if "https" in line:
        linksFile.write(line)

print("Link içeren satirlar dosyaya yazildi.")