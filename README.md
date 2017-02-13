# PoPoolation2 (personal fork)

PoPoolation is a pipeline for analysing pooled next generation sequencing data described in 
[Kofer _et al._ (2011)](https://academic.oup.com/bioinformatics/article/27/24/3435/306737/PoPoolation2-identifying-differentiation-between).

This is a personal fork from the [SourceForge repository](https://sourceforge.net/p/popoolation2/code)
for adding extra features to the code.

## Extra features:

* Support for gzip/bgzip inputs (ending with .gz extension): mpileup, sync and gtf
* Support for gzip output (if ending with .gz extension): sync (not in mpileup2sync.jar and java code)