import { TrendingUp, TrendingDown, Users, Package, ShoppingCart, DollarSign } from 'lucide-react';

export function Dashboard() {
  const stats = [
    {
      label: 'Ventas Totales',
      value: '$45,231',
      change: '+12.5%',
      trend: 'up',
      icon: DollarSign,
      color: 'bg-green-500',
    },
    {
      label: 'Clientes Activos',
      value: '1,234',
      change: '+8.2%',
      trend: 'up',
      icon: Users,
      color: 'bg-blue-500',
    },
    {
      label: 'Productos',
      value: '567',
      change: '-2.4%',
      trend: 'down',
      icon: Package,
      color: 'bg-purple-500',
    },
    {
      label: 'Pedidos',
      value: '89',
      change: '+15.3%',
      trend: 'up',
      icon: ShoppingCart,
      color: 'bg-orange-500',
    },
  ];

  const recentActivities = [
    { id: 1, type: 'Venta', description: 'Nueva venta #1234', time: 'Hace 5 min', status: 'success' },
    { id: 2, type: 'Cliente', description: 'Cliente nuevo registrado', time: 'Hace 15 min', status: 'info' },
    { id: 3, type: 'Producto', description: 'Stock bajo en Producto #456', time: 'Hace 1 hora', status: 'warning' },
    { id: 4, type: 'Factura', description: 'Factura #789 generada', time: 'Hace 2 horas', status: 'success' },
  ];

  return (
    <div className="space-y-6">
      {/* Header */}
      <div>
        <h2 className="text-3xl font-semibold text-slate-900">Dashboard</h2>
        <p className="text-slate-600 mt-1">Resumen de tu negocio</p>
      </div>

      {/* Stats Grid */}
      <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-6">
        {stats.map((stat) => {
          const Icon = stat.icon;
          return (
            <div key={stat.label} className="bg-white rounded-xl shadow-sm p-6 border border-slate-200">
              <div className="flex items-center justify-between mb-4">
                <div className={`${stat.color} w-12 h-12 rounded-lg flex items-center justify-center`}>
                  <Icon className="text-white" size={24} />
                </div>
                <div className={`flex items-center gap-1 text-sm font-medium ${
                  stat.trend === 'up' ? 'text-green-600' : 'text-red-600'
                }`}>
                  {stat.trend === 'up' ? <TrendingUp size={16} /> : <TrendingDown size={16} />}
                  {stat.change}
                </div>
              </div>
              <p className="text-slate-600 text-sm mb-1">{stat.label}</p>
              <p className="text-2xl font-semibold text-slate-900">{stat.value}</p>
            </div>
          );
        })}
      </div>

      {/* Content Grid */}
      <div className="grid grid-cols-1 lg:grid-cols-3 gap-6">
        {/* Recent Activity */}
        <div className="lg:col-span-2 bg-white rounded-xl shadow-sm p-6 border border-slate-200">
          <h3 className="text-lg font-semibold text-slate-900 mb-4">Actividad Reciente</h3>
          <div className="space-y-4">
            {recentActivities.map((activity) => (
              <div key={activity.id} className="flex items-start gap-4 pb-4 border-b border-slate-100 last:border-0 last:pb-0">
                <div className={`w-2 h-2 rounded-full mt-2 flex-shrink-0 ${
                  activity.status === 'success' ? 'bg-green-500' :
                  activity.status === 'warning' ? 'bg-orange-500' :
                  'bg-blue-500'
                }`} />
                <div className="flex-1">
                  <div className="flex items-start justify-between">
                    <div>
                      <p className="font-medium text-slate-900">{activity.type}</p>
                      <p className="text-sm text-slate-600">{activity.description}</p>
                    </div>
                    <span className="text-xs text-slate-500 whitespace-nowrap">{activity.time}</span>
                  </div>
                </div>
              </div>
            ))}
          </div>
        </div>

        {/* Quick Actions */}
        <div className="bg-white rounded-xl shadow-sm p-6 border border-slate-200">
          <h3 className="text-lg font-semibold text-slate-900 mb-4">Acciones Rápidas</h3>
          <div className="space-y-3">
            <button className="w-full bg-blue-600 hover:bg-blue-700 text-white py-3 px-4 rounded-lg transition-colors text-sm font-medium">
              Nueva Venta
            </button>
            <button className="w-full bg-white hover:bg-slate-50 text-slate-700 py-3 px-4 rounded-lg border border-slate-300 transition-colors text-sm font-medium">
              Agregar Cliente
            </button>
            <button className="w-full bg-white hover:bg-slate-50 text-slate-700 py-3 px-4 rounded-lg border border-slate-300 transition-colors text-sm font-medium">
              Nuevo Producto
            </button>
            <button className="w-full bg-white hover:bg-slate-50 text-slate-700 py-3 px-4 rounded-lg border border-slate-300 transition-colors text-sm font-medium">
              Generar Reporte
            </button>
          </div>
        </div>
      </div>

      {/* Table */}
      <div className="bg-white rounded-xl shadow-sm border border-slate-200 overflow-hidden">
        <div className="p-6 border-b border-slate-200">
          <h3 className="text-lg font-semibold text-slate-900">Últimas Ventas</h3>
        </div>
        <div className="overflow-x-auto">
          <table className="w-full">
            <thead className="bg-slate-50">
              <tr>
                <th className="px-6 py-3 text-left text-xs font-medium text-slate-600 uppercase tracking-wider">ID</th>
                <th className="px-6 py-3 text-left text-xs font-medium text-slate-600 uppercase tracking-wider">Cliente</th>
                <th className="px-6 py-3 text-left text-xs font-medium text-slate-600 uppercase tracking-wider">Producto</th>
                <th className="px-6 py-3 text-left text-xs font-medium text-slate-600 uppercase tracking-wider">Monto</th>
                <th className="px-6 py-3 text-left text-xs font-medium text-slate-600 uppercase tracking-wider">Estado</th>
              </tr>
            </thead>
            <tbody className="bg-white divide-y divide-slate-200">
              {[
                { id: '#1234', cliente: 'Juan Pérez', producto: 'Laptop Dell', monto: '$899', estado: 'Completado' },
                { id: '#1233', cliente: 'María García', producto: 'Mouse Logitech', monto: '$45', estado: 'Completado' },
                { id: '#1232', cliente: 'Carlos López', producto: 'Teclado Mecánico', monto: '$120', estado: 'Pendiente' },
                { id: '#1231', cliente: 'Ana Martínez', producto: 'Monitor Samsung', monto: '$350', estado: 'Completado' },
                { id: '#1230', cliente: 'Pedro Sánchez', producto: 'Webcam HD', monto: '$75', estado: 'Procesando' },
              ].map((sale) => (
                <tr key={sale.id} className="hover:bg-slate-50">
                  <td className="px-6 py-4 whitespace-nowrap text-sm font-medium text-slate-900">{sale.id}</td>
                  <td className="px-6 py-4 whitespace-nowrap text-sm text-slate-600">{sale.cliente}</td>
                  <td className="px-6 py-4 whitespace-nowrap text-sm text-slate-600">{sale.producto}</td>
                  <td className="px-6 py-4 whitespace-nowrap text-sm font-medium text-slate-900">{sale.monto}</td>
                  <td className="px-6 py-4 whitespace-nowrap">
                    <span className={`px-2 py-1 text-xs font-medium rounded-full ${
                      sale.estado === 'Completado' ? 'bg-green-100 text-green-800' :
                      sale.estado === 'Pendiente' ? 'bg-yellow-100 text-yellow-800' :
                      'bg-blue-100 text-blue-800'
                    }`}>
                      {sale.estado}
                    </span>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    </div>
  );
}
