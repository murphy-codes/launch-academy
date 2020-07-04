# Before this, I set my root directory to be my challenges folder.
# Which, for me, is located here: C:\Launch_Academy\challenges

# Step 1 - Create the file system
#   Build out the file paths in the image. Every highlighted word is a new directory (folder) and the non-highlighted words are plain old files. Use mkdir and touch to generate this structure.
mkdir directories
cd directories
mkdir Dogs
mkdir e-texts
touch forbidden.text
mkdir images
touch index.html
mkdir Monkeys
touch structure.text
mkdir Dogs/hate
mkdir Dogs/like
touch Dogs/hate/bananas.html
touch Dogs/hate/bones.html
touch Dogs/like/bananas.html
touch Dogs/like/bones.html
touch e-texts/gutindex.all
mkdir e-texts/Maugham,W.Somerset
mkdir e-texts/OReilly,Augustine
mkdir e-texts/Poe,EdgardAllan
touch e-texts/Maugham,W.Somerset/moona10.txt
touch e-texts/Maugham,W.Somerset/moona10.zip
touch e-texts/OReilly,Augustine/'Alvira  The Heroine of Vesuvius.txt'
touch e-texts/Poe,EdgardAllan/poe1v10.txt
touch e-texts/Poe,EdgardAllan/poe1v10.zip
touch e-texts/Poe,EdgardAllan/story2.txt
mkdir images/cartoons
mkdir images/clipart
touch images/cartoons/df950523.jpg
touch images/cartoons/df971202.jpg
mkdir images/clipart/animals
mkdir images/clipart/food
touch images/clipart/animals/dog.gif
touch images/clipart/animals/monkey.gif
touch images/clipart/food/bananas.gif
touch images/clipart/food/bone.gif
mkdir Monkeys/hate
mkdir Monkeys/like
touch Monkeys/hate/bananas.html
touch Monkeys/hate/bones.html
touch Monkeys/like/bananas.html
touch Monkeys/like/bones.html

# Step 2
#   Starting in the root directory, execute a command to navgiate to the directory called food.
cd ~/command-line-drills/directories/images/clipart/food

# Step 3
#   From the food directory, execute a single command to navigate to Poe, EdgarAllen.
cd ~/command-line-drills/directories/e-texts/Poe,EdgardAllan

# Step 4
#   Execute a command from the root directory that describes the contents of Poe, EdgarAllen.
cd ~/
ls command-line-drills/directories/e-texts/Poe,EdgardAllan

# Step 5
#   Navigate to images, and use the command that will tell you the absolute path of where you are in the filesystem.
cd ~/command-line-drills/directories/images
pwd

# Step 6
#   While in images, create a folder called photographs.
mkdir photographs

# Step 7
#   Navigate to your new directory, and create a new file called sunrise. Make it a .jpg file.
cd photographs
touch sunrise.jpg

# Step 8
#   Now move that file up one directory.
mv sunrise.jpg ..

# Step 9
#   Change directories to the like folder under monkeys. Open this folder in VSCode.
cd ~/command-line-drills/directories/Monkeys/like
code .

# Step 10
#   Remove the bananas.html file from the like folder.
rm bananas.html