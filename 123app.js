const EventEmittance = require("events");

class DebouncedEventEmitter extends EventEmittance {
  constructor(debounceTime = 500) {
    super();
    this.debounceTime = debounceTime;
    this.lastEmit = new Map();
  }

  emit(event, ...args) {
    const now = Date.now();
    const lastEmitTime = this.lastEmit.get(event) || 0;

    if (now - lastEmitTime >= this.debounceTime) {
      this.lastEmit.set(event, now);
      super.emit(event, ...args);
    }
  }
}

// Usage
const emitter = new DebouncedEventEmitter(500); // 500ms debounce

emitter.on("event", () => console.log("Event fired"));

setInterval(() => {
  emitter.emit("event");
}, 100);
