import { useState } from 'react';
import React from 'react';
import { Sidebar } from './components/Sidebar';
import { BillingInterface } from './components/BillingInterface';
import { PagePlaceholder } from './components/PagePlaceholder';
import { FileText, UserPlus, PackagePlus, ShoppingCart } from 'lucide-react';

export default function App() {
  const [currentPage, setCurrentPage] = useState('dashboard');

  const renderPage = () => {
    switch (currentPage) {
      case 'dashboard':
        return <BillingInterface />;
      case 'clientes':
        return <PagePlaceholder title="Clientes" description="Gestiona tu base de clientes" />;
      case 'productos':
        return <PagePlaceholder title="Productos" description="Administra tu inventario de productos" />;
      case 'ventas':
        return <PagePlaceholder title="Ventas" description="Registra y consulta ventas" />;
      case 'facturas':
        return <PagePlaceholder title="Facturas" description="Gestiona tus facturas" />;
      case 'reportes':
        return <PagePlaceholder title="Reportes" description="Analiza tus datos de negocio" />;
      case 'configuracion':
        return <PagePlaceholder title="Configuración" description="Ajusta las opciones del sistema" />;
      default:
        return <BillingInterface />;
    }
  };

  return (
    <div className="flex h-screen bg-slate-50">
      {/* Sidebar */}
      <Sidebar onNavigate={setCurrentPage} currentPage={currentPage} />

      {/* Main Content */}
      <div className="flex-1 flex flex-col overflow-hidden">
        {/* Header */}
        <header className="bg-white border-b border-slate-200 px-8 py-4">
          <div className="flex items-center gap-3">
            <button
              onClick={() => setCurrentPage('facturas')}
              className="flex items-center gap-2 px-4 py-2 bg-blue-600 text-white rounded-lg hover:bg-blue-700 transition-colors text-sm font-medium"
            >
              <FileText size={18} />
              Nueva Factura
            </button>
            <button
              onClick={() => setCurrentPage('ventas')}
              className="flex items-center gap-2 px-4 py-2 bg-white border border-slate-300 text-slate-700 rounded-lg hover:bg-slate-50 transition-colors text-sm font-medium"
            >
              <ShoppingCart size={18} />
              Nueva Venta
            </button>
            <button
              onClick={() => setCurrentPage('clientes')}
              className="flex items-center gap-2 px-4 py-2 bg-white border border-slate-300 text-slate-700 rounded-lg hover:bg-slate-50 transition-colors text-sm font-medium"
            >
              <UserPlus size={18} />
              Agregar Cliente
            </button>
            <button
              onClick={() => setCurrentPage('productos')}
              className="flex items-center gap-2 px-4 py-2 bg-white border border-slate-300 text-slate-700 rounded-lg hover:bg-slate-50 transition-colors text-sm font-medium"
            >
              <PackagePlus size={18} />
              Agregar Producto
            </button>
          </div>
        </header>

        {/* Page Content */}
        <main className="flex-1 overflow-y-auto p-8">
          {renderPage()}
        </main>
      </div>
    </div>
  );
}