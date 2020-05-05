#!/usr/bin/perl
    use strict;
    


    my $directory = '/home/stuxnet-il/work/perl';

    opendir (DIR, $directory) or die $!;



     while (my $file = readdir(DIR)) {

        print "\n$file";
        my $mode = (stat($file))[2];
		printf "  permissions are %04o\n", $mode &07777

    }





    printf "\nEnter a name for:";
    my $temp = <STDIN>;

    print "\n you entered :$temp";


    my $directory = '/home/stuxnet-il/work/perl';
    opendir (DIR, $directory) or die $!;
    my %value = 0;
    while (my $file = readdir(DIR)) {

        
        
        if ($temp eq $file){
           my %value = 1;}

    }

    if (%value == 0)
       {printf "\nNot found";}



