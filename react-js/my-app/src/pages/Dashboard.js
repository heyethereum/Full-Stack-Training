const Dashboard = ({ user }) => {
  if (user) {
    localStorage.setItem("localeStorage", "true");
  }
  return (
    <section className="section">
      <h4>Hello, {user?.name}</h4>
    </section>
  );
};
export default Dashboard;
