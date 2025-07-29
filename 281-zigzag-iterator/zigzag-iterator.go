package main

type ZigzagIterator struct {
	v1, v2 []int
	i, j   int  // current indices
	turn   bool // true for v1's turn, false for v2's turn
}

func Constructor(v1, v2 []int) *ZigzagIterator {
	return &ZigzagIterator{
		v1:   v1,
		v2:   v2,
		i:    0,
		j:    0,
		turn: true,
	}
}

func (this *ZigzagIterator) next() int {
	var val int

	// Pick from the current turn's list if it's not exhausted
	if this.turn {
		if this.i < len(this.v1) {
			val = this.v1[this.i]
			this.i++
		} else {
			val = this.v2[this.j]
			this.j++
		}
	} else {
		if this.j < len(this.v2) {
			val = this.v2[this.j]
			this.j++
		} else {
			val = this.v1[this.i]
			this.i++
		}
	}

	// Flip turn for next time
	this.turn = !this.turn
	return val
}

func (this *ZigzagIterator) hasNext() bool {
	return this.i < len(this.v1) || this.j < len(this.v2)
}