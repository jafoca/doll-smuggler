You are a drug trafficker. Every day you meet with a different nice old lady (the mule) and find out how much weight she can carry in her handbag. You then meet with your supplier who has packed various drugs into a myriad of collectible porcelain dolls. Once packed with drugs, each of the precious dolls has a unique combination of weight and street value. Sometimes your supplier has more dolls than grandma can carry, though space in her handbag is never an issue. Your job is to choose which dolls the nice old lady will carry, maximizing street value, while not going over her weight restriction.

Write a program in Clojure that chooses the optimal set of drug-packed porcelain dolls from a set where each has a unique weight and value combination, while staying within a given weight restriction, W, that maximizes the street value of drugs delivered by the grandma, including a set of executable high-level tests for your solution.

## About My Implementation 
My implementation takes a known dataset and applies the algorithm from http://en.wikipedia.org/wiki/Knapsack_problem#0-1_knapsack_problem to solve for the result. The dataset is currently hard-coded into the file, but could be input via a series of prompts eventually.

###How to run:
With my system configuration, I simply navigate to the containing folder via terminal prompt and enter the command "clj doll _ smuggler.clj" to run. You may need to be more verbose and using something like "java -cp clojure.jar:clojure-contrib-1.2.0.jar clojure.main doll _ smuggler.clj"

#####Other sources:
Getting some basics on Clojure:
http://www.moxleystratton.com/article/clojure/for-non-lisp-programmers
Understanding the algorithm for solving 0-1 knapsack:
http://www.youtube.com/watch?v=Z9sMTFh5AXQ&NR=1
Code implementations for solving 0-1:
http://rosettacode.org/wiki/Knapsack_problem/0-1
