# enhanced-second-chance-algorithm-
 Enhanced Second-Chance Algorithm. The enhanced second chance algorithm uses one use bit and a modify bit for each page—many variations of this are possible. When a page is used its use bit is set to 1. We also use a pointer to the next victim which is initialized to the ﬁrst page/frame. When a page is loaded, the next victim pointer will be set to the next frame after the one just loaded. The list of pages is considered as a circular queue. When a page is considered for replacement, the bit pairs for each page are considered &lt;ref,mod>: &lt;0,0> neither recently used nor modiﬁed, best! &lt;0,1> modiﬁed but not recently used, will need to be written. &lt;1,0> recently used but clean—likely to be used again. &lt;1,1> both—likely to be used again and will need to be written. There are three loops through the circular buffer containing these bits that may be used. They are: (a) Cycle through the buffer looking for &lt;0,0>. If one is found, use that page. (b) Cycle through the buffer looking for &lt;0,1>. Set the use bit to zero for all frames bypassed. (c) If step 2 failed, all use bits will now be zero and repetition of steps 1 and 2 are guaranteed to ﬁnd a frame for replacement.
