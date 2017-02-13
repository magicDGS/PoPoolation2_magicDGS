{
    package IOUtils;
    use strict;
    use warnings;
    use IO::Uncompress::Gunzip;
    use IO::Compress::Gzip;
    
    require Exporter;
    our @ISA = qw(Exporter);
    our @EXPORT     =qw(get_maybe_gzip_input_fh get_maybe_gzip_output_fh);

 sub get_maybe_gzip_input_fh {
    my $file=shift;
    my $fh=undef;
    if ($file=~/\.gz$/i) {
        $fh = new IO::Uncompress::Gunzip $file, MultiStream => 1 or die "Could not open gzipped input: $file, $!";
    } else {
        open $fh, "<", $file  or die "Could not open input: $file, $!";
    }
    return $fh;
 }
 
 sub get_maybe_gzip_output_fh {
    my $file=shift;
    my $fh=undef;
    if ($file=~/\.gz$/i) {
        $fh = new IO::Compress::Gzip $file or die "Could not open gzipped output: $file, $!"; 
    } else {
        open $fh, ">", $file  or die "Could not open output: $file, $!";
    }
    return $fh;
 }


}

1;