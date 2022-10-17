import useAuth from "../hooks/useAuth";

const Dashboard = () => {
  const { auth } = useAuth();
  return (
    <section className="section">
      <h4>
        Hello <strong>{auth?.name}</strong>
      </h4>
      <div>Email: {auth?.email}</div>
      <div>Phone: {auth?.phone}</div>
      <div>Address: {auth?.address}</div>
    </section>
  );
};
export default Dashboard;
