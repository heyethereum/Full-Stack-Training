const Dashboard = ({ user }) => {
  return (
    <section className="section">
      <h4>
        Hello <strong>{user?.name}</strong>
      </h4>
      <div>Email: {user.email}</div>
      <div>Phone: {user.phone}</div>
      <div>Address: {user.address}</div>
    </section>
  );
};
export default Dashboard;
