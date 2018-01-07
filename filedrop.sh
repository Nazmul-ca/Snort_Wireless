#!/bin/bash
#****Written_BY:_NAZMUL_For_Project_2017*****
ctrl=true
dropdir=/tmp/snortWireless
# Process PCAP files
echo "Processing PCAP File Drop..."
while $ctrl
do
if [ ! -d "$dropdir" ]
then
    ctrl=false

fi
count=`ls -1 $dropdir/*.pcap 2>/dev/null | wc -l`
if [ $count != 0 ]; then
        tmpdir=$dropdir/temp
        mkdir -p $tmpdir
        for file in $(ls $dropdir/*.pcap); do
                openfile=`lsof $file`
                if [[ -z $openfile ]] ; then
                        mv $file $tmpdir
			else
                        echo "PCAP file in use: $file"
                fi
		count2=`ls -1 $tmpdir/*.pcap 2>/dev/null | wc -l`
		if [ $count2 != 0 ]; then
                    snort -c /etc/snort/snort.conf --pcap-filter="*.pcap" --pcap-dir=$tmpdir
                    rm -fr $tmpdir/*.pcap 
		fi
        done
	rm -fr $tmpdir
else echo "No PCAP detected"
fi
sleep 1
done

