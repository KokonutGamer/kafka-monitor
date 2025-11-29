import KafkaMonitor from "./components/KafkaMonitor"

function App() {
  return (
    <div>
      {/* Navbar */}
      <nav className="navbar navbar-dark bg-dark mb-5">
        <div className="container-fluid">
          <span className="navbar-brand mb-0 h1">Kafka Message Monitor App</span>
        </div>
      </nav>

      {/* Kafka Monitor inside a card */}
      <div className="container">
        <div className="card">
          <div className="card-header">Kafka Message Monitor</div>
          <div className="card-body">
            <KafkaMonitor />
          </div>
        </div>
      </div>
    </div>
  )
}

export default App
