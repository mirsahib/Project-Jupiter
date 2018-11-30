all:
	gcc -ggdb -pthread -std=gnu99 producer_a.c `pkg-config --cflags --libs gsl` -o producer_a
	gcc -std=gnu99 consumer_a.c -o consumer_a
clean:
	rm rf *o producer_a consumer_a 
