#!/usr/bin/python
import commands, re, sys

result = commands.getoutput("df -Ph | grep '^/dev' | awk '{print $6, $5}'")

data = {}

for line in str(result).split('\n'):
  if line:
    print(line)
    dev = line.split()[0].strip()
    print(dev)
    percent = int(line.split()[1].strip()[:-1])
    if not data.has_key(dev):
      data[dev] = percent


output = ''

expected_percent = int(sys.argv[1])

for dev,percent in data.iteritems():
  if percent > expected_percent:
    failed_message = "FAILED: \"" + dev + "\" is at "  + str(percent) + "%!\n"
    output = output + failed_message


if output:
  print output
